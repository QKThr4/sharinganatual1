package com.sharinganmod.logic;

import com.sharinganmod.data.Skills;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

/**
 * Olho de Mangekyou (ja inclui o Sharingan de 3 tomoe). kind: 1 Itachi, 2 Sasuke, 3 Obito, 4 Shisui,
 * 5 Mangekyou Eterno. Clique direito para implantar; substitui o Sharingan que o jogador tiver.
 */
public class EyeItem extends Item {
    public final int kind;

    public EyeItem(Properties props, int kind) {
        super(props);
        this.kind = kind;
    }

    /** Marca o olho de Obito como inteiro (retirado de quem tinha os dois olhos). Sem marca = meio olho. */
    public static void setFull(ItemStack stack, boolean full) {
        CompoundTag t = new CompoundTag();
        t.putBoolean("full", full);
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(t));
    }

    public static boolean isFull(ItemStack stack) {
        CustomData cd = stack.get(DataComponents.CUSTOM_DATA);
        return cd != null && cd.copyTag().getBoolean("full");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) return InteractionResultHolder.success(stack);
        if (!(player instanceof ServerPlayer sp)) return InteractionResultHolder.fail(stack);
        ItemStack old = SharinganLogic.transplant(sp, kind, stack);
        return SharinganLogic.finishUse(sp, stack, old);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> tip, TooltipFlag flag) {
        if (kind == 5) {
            tip.add(Component.literal("Mangekyou Sharingan Eterno (já inclui o 3 Tomoe).")
                    .withStyle(ChatFormatting.DARK_RED));
        } else if (kind == 3) {
            tip.add(Component.literal(isFull(stack) ? "Olho de Obito inteiro (já inclui o 3 Tomoe)."
                    : "Metade do olho de Obito (já inclui o 3 Tomoe).").withStyle(ChatFormatting.DARK_PURPLE));
            tip.add(Component.literal("Quem já tem a outra metade recupera os dois olhos.")
                    .withStyle(ChatFormatting.DARK_PURPLE));
        } else {
            tip.add(Component.literal("Mangekyou de " + Skills.TYPE_NAMES[kind] + " (já inclui o 3 Tomoe).")
                    .withStyle(ChatFormatting.DARK_RED));
            if (kind == 1 || kind == 2) {
                tip.add(Component.literal("Junto do Mangekyou de " + Skills.TYPE_NAMES[kind == 1 ? 2 : 1]
                        + " forma o Mangekyou Eterno.").withStyle(ChatFormatting.DARK_RED));
            }
        }
        tip.add(Component.literal("Clique direito para implantar: substitui o Sharingan que você tiver")
                .withStyle(ChatFormatting.GRAY));
        tip.add(Component.literal("(o antigo volta como item). Sem o Clã Uchiha: recargas e custos maiores.")
                .withStyle(ChatFormatting.GRAY));
    }
}
