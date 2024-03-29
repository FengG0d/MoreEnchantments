package cn.feng.enchant.enchantment;

import cn.feng.enchant.MoreEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

/**
 * @author ChengFeng
 * @since 2024/2/26
 **/
public class SchrodingerCurseEnchantment extends Enchantment {
    public SchrodingerCurseEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEARABLE, MoreEnchantments.ALL_ARMOR);
    }

    @Override
    public boolean isCursed() {
        return true;
    }
}
