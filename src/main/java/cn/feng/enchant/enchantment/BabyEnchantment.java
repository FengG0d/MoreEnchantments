package cn.feng.enchant.enchantment;

import cn.feng.enchant.MoreEnchantments;
import cn.feng.enchant.util.EntityUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;

/**
 * @author ChengFeng
 * @since 2024/3/3
 **/
public class BabyEnchantment extends Enchantment {
    public BabyEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, MoreEnchantments.ALL_ARMOR);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            int newAge = EntityUtil.getAge(livingEntity) - 3 * level;
            EntityUtil.setAge(livingEntity, newAge);

            if (newAge <= 0) {
                EntityUtil.removeAge(livingEntity);
                livingEntity.kill();

                EntityUtil.setAge(user, EntityUtil.getAge(user) + 6 * level);
                user.sendMessage(Text.literal("你利用救人之术杀人，罪大恶极，折寿 " + 6 * level + " 年！"));
            } else {
                EntityUtil.setAge(user, EntityUtil.getAge(user) - 3 * level);
                user.sendMessage(Text.literal("你使用秘法让对方延寿 " + 6 * level + " 年，功德无量，年轻 " + 3 * level + " 岁！"));
            }
        }
    }
}
