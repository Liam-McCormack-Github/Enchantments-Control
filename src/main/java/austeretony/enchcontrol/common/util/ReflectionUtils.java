package austeretony.enchcontrol.common.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static EntityEquipmentSlot[] getApplicableEquipmentTypes(Enchantment enchantment) {
        try {
            Field field = Enchantment.class.getDeclaredField("applicableEquipmentTypes");
            field.setAccessible(true);
            return (EntityEquipmentSlot[]) field.get(enchantment);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return new EntityEquipmentSlot[0];
        }
    }

    public static void setApplicableEquipmentTypes(Enchantment enchantment, EntityEquipmentSlot[] equipmentSlots) {
        try {
            Field field = Enchantment.class.getDeclaredField("applicableEquipmentTypes");
            field.setAccessible(true);
            field.set(enchantment, equipmentSlots);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Enchantment.Rarity getRarity(Enchantment enchantment) {
        try {
            Field field = Enchantment.class.getDeclaredField("rarity");
            field.setAccessible(true);
            return (Enchantment.Rarity) field.get(enchantment);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return Enchantment.Rarity.COMMON;
        }
    }

    public static void setRarity(Enchantment enchantment, Enchantment.Rarity rarity) {
        try {
            Field field = Enchantment.class.getDeclaredField("rarity");
            field.setAccessible(true);
            field.set(enchantment, rarity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
