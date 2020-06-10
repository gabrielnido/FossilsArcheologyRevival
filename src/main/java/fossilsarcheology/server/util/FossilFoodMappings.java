package fossilsarcheology.server.util;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.prehistoric.*;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"ConstantConditions"})
public class FossilFoodMappings {

    public static void register() {
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.REEDS), 15);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.WHEAT), 13);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.MELON), 10);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.APPLE), 20);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.BEETROOT), 20);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.POTATO), 35);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.BAKED_POTATO), 35);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.CAKE), 50);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.CARROT), 15);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.COOKIE), 10);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.PUMPKIN_PIE), 25);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.SUGAR), 7);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.BREAD), 25);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.WHEAT_SEEDS), 5);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.MELON_SEEDS), 5);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.PUMPKIN_SEEDS), 5);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.BEETROOT_SEEDS), 5);
        FoodMappings.INSTANCE.addPlant(Blocks.CAKE, 35);
        FoodMappings.INSTANCE.addPlant(Blocks.CARROTS, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.WHEAT, 10);
        FoodMappings.INSTANCE.addPlant(Blocks.HAY_BLOCK, 90);
        FoodMappings.INSTANCE.addPlant(Blocks.LEAVES, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.MELON_BLOCK, 65);
        FoodMappings.INSTANCE.addPlant(Blocks.BROWN_MUSHROOM, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.RED_MUSHROOM, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.RED_FLOWER, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.YELLOW_FLOWER, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.POTATOES, 25);
        FoodMappings.INSTANCE.addPlant(Blocks.PUMPKIN, 30);
        FoodMappings.INSTANCE.addPlant(Blocks.REEDS, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.SAPLING, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.TALLGRASS, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.WATERLILY, 15);
        FoodMappings.INSTANCE.addPlant(FABlockRegistry.FERNS, 10);
        FoodMappings.INSTANCE.addPlant(FABlockRegistry.PALM_LEAVES, 40);
        FoodMappings.INSTANCE.addPlant(Blocks.CHORUS_FLOWER, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.CHORUS_PLANT, 10);
        FoodMappings.INSTANCE.addPlant(new ItemStack(Items.CHORUS_FRUIT), 15);

        FoodMappings.INSTANCE.addFish(new ItemStack(Items.FISH), 20);
        FoodMappings.INSTANCE.addFish(new ItemStack(Items.FISH, 1, 1), 20);
        FoodMappings.INSTANCE.addFish(new ItemStack(Items.FISH, 1, 2), 15);
        FoodMappings.INSTANCE.addFish(new ItemStack(Items.FISH, 1, 3), 15);
        FoodMappings.INSTANCE.addFish(new ItemStack(Items.COOKED_FISH), 45);
        FoodMappings.INSTANCE.addFish(new ItemStack(Items.COOKED_FISH, 1, 1), 45);
        FoodMappings.INSTANCE.addFish(new ItemStack(FAItemRegistry.SJL), 65);

        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.COOKED_BEEF), 60);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.BEEF), 40);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.COOKED_CHICKEN), 15);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.CHICKEN), 10);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.PORKCHOP), 35);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.COOKED_PORKCHOP), 55);
        FoodMappings.INSTANCE.addMeat(new ItemStack(FAItemRegistry.FAILURESAURUS_FLESH), 15);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.MUTTON), 30);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.COOKED_MUTTON), 50);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.RABBIT), 13);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.COOKED_RABBIT), 17);
        FoodMappings.INSTANCE.addMeat(new ItemStack(Items.RABBIT_FOOT), 7);

        FoodMappings.INSTANCE.addEgg(new ItemStack(Items.EGG), 7);

        for (int i = 0; i < PrehistoricEntityType.values().length; i++) {
            PrehistoricEntityType entityType = PrehistoricEntityType.values()[i];
            if (entityType.timePeriod != TimePeriod.CURRENT) {
                if (entityType.mobType != MobType.FISH) {
                    FoodMappings.INSTANCE.addMeat(new ItemStack(entityType.foodItem), 25);
                    FoodMappings.INSTANCE.addMeat(new ItemStack(entityType.cookedFoodItem), 35);
                } else {
                    FoodMappings.INSTANCE.addFish(new ItemStack(entityType.eggItem), 35);
                    FoodMappings.INSTANCE.addFish(new ItemStack(entityType.fishItem), 35);
                    FoodMappings.INSTANCE.addFish(new ItemStack(entityType.cookedFoodItem), 75);
                }
            }
            if (entityType.mobType == MobType.BIRD || entityType.mobType == MobType.CHICKEN) {
                FoodMappings.INSTANCE.addEgg(new ItemStack(entityType.bestBirdEggItem), 15);
                if (PrehistoricEntityType.values()[i].mobType != MobType.CHICKEN) {
                    FoodMappings.INSTANCE.addEgg(new ItemStack(entityType.birdEggItem), 10);
                }
            }
        }

        FoodMappings.INSTANCE.addMeat(EntityPlayer.class, 27);
        FoodMappings.INSTANCE.addMeat(EntityPlayerMP.class, 27);
        FoodMappings.INSTANCE.addMeat(EntityVillager.class, 27);
        FoodMappings.INSTANCE.addMeat(EntityZombie.class, 23);
        FoodMappings.INSTANCE.addMeat(EntityChicken.class, 5);
        FoodMappings.INSTANCE.addMeat(EntityRabbit.class, 7);
        FoodMappings.INSTANCE.addMeat(EntityParrot.class, 1);
        FoodMappings.INSTANCE.addMeat(EntityLlama.class, 35);
        FoodMappings.INSTANCE.addMeat(EntityPolarBear.class, 60);
        FoodMappings.INSTANCE.addMeat(EntityCow.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityHorse.class, 55);
        FoodMappings.INSTANCE.addMeat(EntityPig.class, 20);
        FoodMappings.INSTANCE.addMeat(EntitySheep.class, 35);
        FoodMappings.INSTANCE.addMeat(EntitySquid.class, 30);
        FoodMappings.INSTANCE.addMeat(EntityWolf.class, 15);
        FoodMappings.INSTANCE.addMeat(EntityOcelot.class, 10);
        FoodMappings.INSTANCE.addMeat(EntityGuardian.class, 65);
        FoodMappings.INSTANCE.addMeat(EntityNautilus.class, 100);
        FoodMappings.INSTANCE.addMeat(EntityTriceratops.class, 120);
        FoodMappings.INSTANCE.addMeat(EntityVelociraptor.class, 20);
        FoodMappings.INSTANCE.addMeat(EntityTyrannosaurus.class, 120);
        FoodMappings.INSTANCE.addMeat(EntityPteranodon.class, 35);
        FoodMappings.INSTANCE.addMeat(EntityMosasaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntitySarcosuchus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityLiopleurodon.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityStegosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityDilophosaurus.class, 25);
        FoodMappings.INSTANCE.addMeat(EntityBrachiosaurus.class, 90);
        FoodMappings.INSTANCE.addMeat(EntitySpinosaurus.class, 70);
        FoodMappings.INSTANCE.addMeat(EntityCompsognathus.class, 10);
        FoodMappings.INSTANCE.addMeat(EntityAnkylosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityPachycephalosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityDeinonychus.class, 35);
        FoodMappings.INSTANCE.addMeat(EntityGallimimus.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityAllosaurus.class, 25);
        FoodMappings.INSTANCE.addMeat(EntityDodo.class, 20);
        FoodMappings.INSTANCE.addMeat(EntityQuagga.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityTitanis.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityOrnitholestes.class, 25);
        FoodMappings.INSTANCE.addMeat(EntityPhorusrhacos.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityKelenken.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityTitanis.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityMammoth.class, 100);
        FoodMappings.INSTANCE.addMeat(EntityElasmotherium.class, 80);
        FoodMappings.INSTANCE.addMeat(EntityConfuciusornis.class, 15);
        FoodMappings.INSTANCE.addMeat(EntityCeratosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityDryosaurus.class, 25);
        FoodMappings.INSTANCE.addMeat(EntityTherizinosaurus.class, 125);
        FoodMappings.INSTANCE.addMeat(EntityParasaurolophus.class, 150);
        FoodMappings.INSTANCE.addMeat(EntityPlatybelodon.class, 90);
        FoodMappings.INSTANCE.addFish(EntityCoelacanth.class, 20);
        FoodMappings.INSTANCE.addFish(EntitySturgeon.class, 20);
        FoodMappings.INSTANCE.addFish(EntityAlligatorGar.class, 20);
        FoodMappings.INSTANCE.addMeat(EntityMeganeura.class, 15);
        FoodMappings.INSTANCE.addMeat(EntityMegaloceros.class, 60);
        FoodMappings.INSTANCE.addMeat(EntityMegalania.class, 70);
        FoodMappings.INSTANCE.addMeat(EntityEdaphosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityArthropleura.class, 30);
        FoodMappings.INSTANCE.addMeat(EntityCitipati.class, 60);
        FoodMappings.INSTANCE.addMeat(EntityDiplodocus.class, 160);
        FoodMappings.INSTANCE.addMeat(EntityMegalograptus.class, 25);
        FoodMappings.INSTANCE.addMeat(EntitySmilodon.class, 35);
        FoodMappings.INSTANCE.addFish(EntityMegalograptus.class, 25);
        FoodMappings.INSTANCE.addFish(EntityNautilus.class, 30);
        FoodMappings.INSTANCE.addFish(EntityCoelacanth.class, 40);
        FoodMappings.INSTANCE.addFish(EntityAlligatorGar.class, 50);
        FoodMappings.INSTANCE.addFish(EntitySturgeon.class, 50);
        FoodMappings.INSTANCE.addFish(EntitySquid.class, 40);
        FoodMappings.INSTANCE.addFish(EntityTiktaalik.class, 40);
        FoodMappings.INSTANCE.addFish(EntityCrassigyrinus.class, 35);
        FoodMappings.INSTANCE.addMeat(EntityDiplocaulus.class, 20);
        FoodMappings.INSTANCE.addFish(EntityDiplocaulus.class, 20);
        FoodMappings.INSTANCE.addInsect(EntitySpider.class, 30);
        FoodMappings.INSTANCE.addInsect(EntityCaveSpider.class, 15);
        FoodMappings.INSTANCE.addMeatEntity("rats:rat", 5);
        FoodMappings.INSTANCE.addMeatEntity("historicizedmedicine:rat", 5);
        FoodMappings.INSTANCE.addMeatEntity("bewitchment:lizard", 3);
        FoodMappings.INSTANCE.addMeatEntity("bewitchment:toad", 3);
        FoodMappings.INSTANCE.addMeatEntity("bewitchment:newt", 3);
        FoodMappings.INSTANCE.addMeatEntity("bewitchment:snake", 4);
        FoodMappings.INSTANCE.addMeatEntity("bewitchment:raven", 5);
        FoodMappings.INSTANCE.addMeatEntity("bewitchment:owl", 7);
        FoodMappings.INSTANCE.addMeatEntity("familiarfauna:familiarfauna.deer", 35);
        FoodMappings.INSTANCE.addMeatEntity("familiarfauna:familiarfauna.turkey", 10);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:deer", 35);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:goat", 25);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:pheasant", 10);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:turkey", 10);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:goose", 10);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:boar", 30);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:moose", 45);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:reindeer", 35);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:squirrel", 3);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:songbird", 3);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:lammergeier", 8);
        FoodMappings.INSTANCE.addMeatEntity("totemic:buffalo", 55);
        FoodMappings.INSTANCE.addMeatEntity("totemic:bald_eagle", 8);
        FoodMappings.INSTANCE.addMeatEntity("covetedmobs:blindworm,", 4);
        FoodMappings.INSTANCE.addMeatEntity("covetedmobs:newt", 3);
        FoodMappings.INSTANCE.addMeatEntity("covetedmobs:oryx", 35);
        FoodMappings.INSTANCE.addMeatEntity("covetedmobs:elephant", 75);
        FoodMappings.INSTANCE.addMeatEntity("covetedmobs:tiger", 30);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:cicaptera_azure", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:cicaptera_verdant", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:cicaptera_crimson", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:cicaptera_sandy", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:cicaptera_wintry", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:cicaptera_lovely", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:plumper", 25);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:krill", 10);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:yaga_hog", 25);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:dusk_lurker", 25);
        FoodMappings.INSTANCE.addMeatEntity("mysticalwildlife:vrontausaurus", 45);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:crab", 5);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:walrus", 35);
        FoodMappings.INSTANCE.addMeatEntity("betteranimalsplus:whale", 65);
        FoodMappings.INSTANCE.addMeatEntity("quark:crab", 5);
        FoodMappings.INSTANCE.addMeatEntity("quark:frog", 3);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:chinchilla", 3);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:gecko", 3);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:gemsbok", 35);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:hedgehog", 5);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:capybara", 25);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:giraffe", 55);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:anteater", 25);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:rhino", 37);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:camel", 25);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:frog", 3);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:porcupine", 7);
        FoodMappings.INSTANCE.addMeatEntity("zoocraftdiscoveries:tapir", 25);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:cassowary", 25);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:duck", 10);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:flamingo", 7);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:gouldianfinch", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:hummingbird", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:kingfisher", 5);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:kiwi", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:lyrebird", 5);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:magpie", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:ostrich", 27);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:owl", 7);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:parrot", 5);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:peafowl", 10);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:pelican", 5);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:emperorpenguin", 7);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:pigeon", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:roadrunner", 5);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:seagull", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:swan", 12);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:toucan", 7);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:vulture", 7);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:woodpecker", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:heron", 15);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:booby", 7);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:cardinal", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:bluejay", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:robin", 3);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:crane", 15);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:kookaburra", 5);
        FoodMappings.INSTANCE.addMeatEntity("exoticbirds:budgerigar", 3);
        FoodMappings.INSTANCE.addInsectEntity("mysticalwildlife:cicaptera_azure", 10);
        FoodMappings.INSTANCE.addInsectEntity("mysticalwildlife:cicaptera_verdant", 10);
        FoodMappings.INSTANCE.addInsectEntity("mysticalwildlife:cicaptera_crimson", 10);
        FoodMappings.INSTANCE.addInsectEntity("mysticalwildlife:cicaptera_sandy", 10);
        FoodMappings.INSTANCE.addInsectEntity("mysticalwildlife:cicaptera_wintry", 10);
        FoodMappings.INSTANCE.addInsectEntity("mysticalwildlife:cicaptera_lovely", 10);
        FoodMappings.INSTANCE.addInsectEntity("covetedmobs:pelicanspider", 25);
        FoodMappings.INSTANCE.addInsectEntity("futuremc:bee", 2);
        FoodMappings.INSTANCE.addMeatEntity("futuremc:panda", 35);
        FoodMappings.INSTANCE.addFishEntity("mysticalwildlife:krill", 10);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:horseshoecrab", 13);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:nautilus", 15);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:lamprey", 5);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:crab", 5);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:shark", 40);
        FoodMappings.INSTANCE.addFishEntity("jaff:clownfish", 5);
        FoodMappings.INSTANCE.addFishEntity("jaff:cod", 5);
        FoodMappings.INSTANCE.addFishEntity("jaff:pufferfish", 5);
        FoodMappings.INSTANCE.addFishEntity("jaff:salmon", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:swordfish", 15);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:seahorse", 15);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:sailfish", 15);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:raccoon_butterflyfish", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:masked_butterflyfish", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:fish", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:fairy_basslet", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:clownfish", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:butterflyfish", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:bannerfish", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:blackcap_basslet", 5);
        FoodMappings.INSTANCE.addFishEntity("abyssaldepths:spotfin_butterflyfish", 5);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:eel_saltwater", 8);
        FoodMappings.INSTANCE.addFishEntity("betteranimalsplus:eel_freshwater", 8);
        FoodMappings.INSTANCE.addFishEntity("quark:crab", 5);
        FoodMappings.INSTANCE.addFishEntity("futuremc:cod", 5);
        FoodMappings.INSTANCE.addFishEntity("futuremc:pufferfish", 5);
        FoodMappings.INSTANCE.addFishEntity("futuremc:salmon", 5);
        FoodMappings.INSTANCE.addFishEntity("futuremc:tropical_fish", 5);
        FoodMappings.INSTANCE.removeItemMapping(new ItemStack(PrehistoricEntityType.HORSE.embryoItem), Diet.CARNIVORE_EGG);
        FoodMappings.INSTANCE.addFish("listAllfishraw", 5);
        FoodMappings.INSTANCE.addFish("foodOctopuscooked", 30);
        FoodMappings.INSTANCE.addFish("listAllfishcooked", 45);
        FoodMappings.INSTANCE.addFish("foodCalamariraw", 30);
        FoodMappings.INSTANCE.addFish("foodCalamaricooked", 45);
        FoodMappings.INSTANCE.addFish("foodClamraw", 15);
        FoodMappings.INSTANCE.addFish("foodCrabraw", 10);
        FoodMappings.INSTANCE.addFish("foodCrabcooked", 15);
        FoodMappings.INSTANCE.addFish("foodShrimpcooked", 13);
        FoodMappings.INSTANCE.addFish("foodSnailcooked", 10);
        FoodMappings.INSTANCE.addFish("foodClamcooked", 22);
        FoodMappings.INSTANCE.addFish("foodCookedClam", 22);
        FoodMappings.INSTANCE.addFish("cookingClam", 15);
        FoodMappings.INSTANCE.addPlant("cropYuzu", 20);
        FoodMappings.INSTANCE.addPlant("listAllfruit", 20);
        FoodMappings.INSTANCE.addPlant("listAllveggie", 15);
        FoodMappings.INSTANCE.addPlant("listAllrootveggie", 15);
        FoodMappings.INSTANCE.addPlant("cropWildcarrots", 15);
        FoodMappings.INSTANCE.addPlant("foodMushroompowder", 5);
        FoodMappings.INSTANCE.addPlant("listAllgreenveggie", 15);
        FoodMappings.INSTANCE.addPlant("listAllmushroom", 15);
        FoodMappings.INSTANCE.addPlant("listAllberry", 7);
        FoodMappings.INSTANCE.addPlant("cropStrawberry", 7);
        FoodMappings.INSTANCE.addPlant("cropCamellia", 5);
        FoodMappings.INSTANCE.addPlant("cropCassis", 7);
        FoodMappings.INSTANCE.addPlant("treeLeaves", 20);
        FoodMappings.INSTANCE.addPlant("treeSapling", 15);
        FoodMappings.INSTANCE.addPlant("sapling", 15);
        FoodMappings.INSTANCE.addPlant("saplingPalm", 15);
        FoodMappings.INSTANCE.addPlant("leaves", 20);
        FoodMappings.INSTANCE.addPlant("leavesPalm", 20);
        FoodMappings.INSTANCE.addPlant("listAllgrain", 10);
        FoodMappings.INSTANCE.addPlant("cropRice", 10);
        FoodMappings.INSTANCE.addPlant("cropCorn", 10);
        FoodMappings.INSTANCE.addPlant("reedTypha", 15);
        FoodMappings.INSTANCE.addPlant("listAllnut", 15);
        FoodMappings.INSTANCE.addPlant("listAllseed", 5);
        FoodMappings.INSTANCE.addPlant("cropCoconut", 20);
        FoodMappings.INSTANCE.addPlant("listAllherb", 10);
        FoodMappings.INSTANCE.addPlant("listAllspice", 10);
        FoodMappings.INSTANCE.addPlant("cropEdibleroot", 7);
        FoodMappings.INSTANCE.addPlant("cropSesame", 5);
        FoodMappings.INSTANCE.addPlant("listAllpepper", 5);
        FoodMappings.INSTANCE.addPlant("cropAvocado", 20);
        FoodMappings.INSTANCE.addPlant("cropApple", 20);
        FoodMappings.INSTANCE.addPlant("cropCherry", 5);
        FoodMappings.INSTANCE.addPlant("cropWalnut", 7);
        FoodMappings.INSTANCE.addPlant("cropChestnut", 7);
        FoodMappings.INSTANCE.addPlant("cropLemon", 10);
        FoodMappings.INSTANCE.addPlant("cropPlum", 10);
        FoodMappings.INSTANCE.addPlant("cropDate", 5);
        FoodMappings.INSTANCE.addPlant("cropDate", 10);
        FoodMappings.INSTANCE.addPlant("cropOrange", 10);
        FoodMappings.INSTANCE.addPlant("cropKumquat", 7);
        FoodMappings.INSTANCE.addPlant("cropLime", 10);
        FoodMappings.INSTANCE.addPlant("cropBlackthorn", 7);
        FoodMappings.INSTANCE.addPlant("cropAlmond", 7);
        FoodMappings.INSTANCE.addPlant("cropApricot", 10);
        FoodMappings.INSTANCE.addPlant("cropGrapefruit", 15);
        FoodMappings.INSTANCE.addPlant("cropPeach", 10);
        FoodMappings.INSTANCE.addPlant("cropCitron", 20);
        FoodMappings.INSTANCE.addPlant("cropPomelo", 25);
        FoodMappings.INSTANCE.addPlant("cropPear", 20);
        FoodMappings.INSTANCE.addPlant("cropSandPear", 20);
        FoodMappings.INSTANCE.addPlant("cropHazelnut", 10);
        FoodMappings.INSTANCE.addPlant("cropBeechnut", 10);
        FoodMappings.INSTANCE.addPlant("cropPecan", 10);
        FoodMappings.INSTANCE.addPlant("cropBanana", 15);
        FoodMappings.INSTANCE.addPlant("cropPlantain", 15);
        FoodMappings.INSTANCE.addPlant("cropBrazilNut", 10);
        FoodMappings.INSTANCE.addPlant("cropFig", 12);
        FoodMappings.INSTANCE.addPlant("cropAcorn", 5);
        FoodMappings.INSTANCE.addPlant("cropElderberry", 7);
        FoodMappings.INSTANCE.addPlant("cropOlive", 7);
        FoodMappings.INSTANCE.addPlant("cropGinkgoNut", 7);
        FoodMappings.INSTANCE.addPlant("cropOsangeOrange", 30);
        FoodMappings.INSTANCE.addPlant("cropClove", 7);
        FoodMappings.INSTANCE.addPlant("cropDurian", 25);
        FoodMappings.INSTANCE.addPlant("cropTea", 10);
        FoodMappings.INSTANCE.addPlant("cropSpiceleaf", 10);
        FoodMappings.INSTANCE.addPlant("cropCurryleaf", 10);
        FoodMappings.INSTANCE.addPlant("cropCoffee", 5);
        FoodMappings.INSTANCE.addPlant("cropNutmeg", 7);
        FoodMappings.INSTANCE.addPlant("cropCoffee", 5);
        FoodMappings.INSTANCE.addPlant("cropCinnamon", 5);
        FoodMappings.INSTANCE.addPlant("cropVanillabean", 5);
        FoodMappings.INSTANCE.addPlant("cropMaplesyrup", 5);
        FoodMappings.INSTANCE.addPlant("dropHoney", 7);
        FoodMappings.INSTANCE.addPlant("foodSugar", 7);
        FoodMappings.INSTANCE.addPlant("bamboo", 8);
        FoodMappings.INSTANCE.addPlant("cropTaro", 6);
        FoodMappings.INSTANCE.addPlant("cropCentella", 8);
        FoodMappings.INSTANCE.addPlant("cropLaksaLeaf", 7);
        FoodMappings.INSTANCE.addPlant("cropSacredLotus", 10);
        FoodMappings.INSTANCE.addPlant("cropWasabi", 6);
        FoodMappings.INSTANCE.addPlant("cropWatercress", 7);
        FoodMappings.INSTANCE.addPlant("cropWaterSpinach", 7);
        FoodMappings.INSTANCE.addPlant("cropWildRice", 10);
        FoodMappings.INSTANCE.addPlant("groundcoverClover", 5);
        FoodMappings.INSTANCE.addPlant("groundcoverGrassGRNLT", 5);
        FoodMappings.INSTANCE.addPlant("groundcoverGrassGRNDK", 5);
        FoodMappings.INSTANCE.addPlant("groundcoverFlowers", 6);
        FoodMappings.INSTANCE.addPlant("groundcoverIvy", 5);
        FoodMappings.INSTANCE.addPlant("floatingDuckweed", 5);
        FoodMappings.INSTANCE.addPlant("grassSwitch", 10);
        FoodMappings.INSTANCE.addPlant("forestWildMint", 6);
        FoodMappings.INSTANCE.addPlant("plainsReedCanaryGrass", 10);
        FoodMappings.INSTANCE.addPlant("grassSilverMoor", 10);
        FoodMappings.INSTANCE.addPlant("grassSeaOats", 10);
        FoodMappings.INSTANCE.addPlant("grassBlueWheatgrass", 10);
        FoodMappings.INSTANCE.addPlant("grassCord", 10);
        FoodMappings.INSTANCE.addPlant("grassFountain", 10);
        FoodMappings.INSTANCE.addPlant("grassPrairie", 10);
        FoodMappings.INSTANCE.addPlant("grassMeadow", 10);
        FoodMappings.INSTANCE.addPlant("grassMaiden", 10);
        FoodMappings.INSTANCE.addPlant("beachSeaLymeGrass", 10);
        FoodMappings.INSTANCE.addPlant("grassMeadowFoxtail", 10);
        FoodMappings.INSTANCE.addPlant("shrubLavender", 7);
        FoodMappings.INSTANCE.addPlant("immersedCommonReed", 8);
        FoodMappings.INSTANCE.addPlant("immersedDuckPotato", 7);
        FoodMappings.INSTANCE.addPlant("immersedArrowArum", 8);
        FoodMappings.INSTANCE.addPlant("immersedGreySedge", 7);
        FoodMappings.INSTANCE.addPlant("immersedYellowFlag", 8);
        FoodMappings.INSTANCE.addPlant("immersedEuropeanBurReed", 7);
        FoodMappings.INSTANCE.addPlant("immersedSimplestemBurReed", 8);
        FoodMappings.INSTANCE.addPlant("immersedSoftstemBulrush", 7);
        FoodMappings.INSTANCE.addPlant("immersedWaterMannagrass", 8);
        FoodMappings.INSTANCE.addPlant("riverAmazonSword", 8);
        FoodMappings.INSTANCE.addPlant("riverCanadianWaterweed", 7);
        FoodMappings.INSTANCE.addPlant("riverCoonsTail", 8);
        FoodMappings.INSTANCE.addPlant("waterCryptWendtii", 7);
        FoodMappings.INSTANCE.addPlant("waterDwarfHairGrass", 8);
        FoodMappings.INSTANCE.addPlant("riverEelgrass", 7);
        FoodMappings.INSTANCE.addPlant("riverWrightsWaternymph", 8);
        FoodMappings.INSTANCE.addPlant("waterMondoGrass", 7);
        FoodMappings.INSTANCE.addPlant("riverWaterWisteria", 8);
        FoodMappings.INSTANCE.addPlant("oceanCommonEelgrass", 8);
        FoodMappings.INSTANCE.addPlant("waterKelpGiantGRN", 7);
        FoodMappings.INSTANCE.addPlant("waterKelpGiantYEL", 8);
        FoodMappings.INSTANCE.addPlant("oceanSeaGrapes", 7);
        FoodMappings.INSTANCE.addPlant("oceanMozuku", 8);
        FoodMappings.INSTANCE.addPlant("oceanRockweed", 7);
        FoodMappings.INSTANCE.addPlant("oceanTangle", 8);
        FoodMappings.INSTANCE.addPlant("oceanSeaLettuce", 7);
        FoodMappings.INSTANCE.addPlant("floatingWaterLettuce", 8);
        FoodMappings.INSTANCE.addPlant("floatingWaterHyacinth", 7);
        FoodMappings.INSTANCE.addPlant("flowerThistle", 6);
        FoodMappings.INSTANCE.addPlant("cropVine", 6);
        FoodMappings.INSTANCE.addPlant("cropIronberry", 10);
        FoodMappings.INSTANCE.addPlant("cropWildberry", 6);
        FoodMappings.INSTANCE.addPlant("cropGrape", 8);
        FoodMappings.INSTANCE.addPlant("cropPepper", 8);
        FoodMappings.INSTANCE.addPlant("cropChilipepper", 8);
        FoodMappings.INSTANCE.addPlant("foodVegetable", 15);
        FoodMappings.INSTANCE.addPlant("fruitForestry", 20);
        FoodMappings.INSTANCE.addPlant("foodBerry", 7);
        FoodMappings.INSTANCE.addPlant("cropRice", 13);
        FoodMappings.INSTANCE.addPlant("cropQuinoa", 13);
        FoodMappings.INSTANCE.addPlant("cropSaltwort", 12);
        FoodMappings.INSTANCE.addPlant("ingredientVegNugget", 7);
        FoodMappings.INSTANCE.addPlant("plant", 5);
        FoodMappings.INSTANCE.addPlant("foodBush", 5);
        FoodMappings.INSTANCE.addPlant("plantDampgrass", 5);
        FoodMappings.INSTANCE.addPlant("plantShortgrass", 5);
        FoodMappings.INSTANCE.addPlant("plantMediumgrass", 5);
        FoodMappings.INSTANCE.addPlant("plantWheatgrass", 5);
        FoodMappings.INSTANCE.addPlant("plantDesertgrass", 5);
        FoodMappings.INSTANCE.addPlant("plantDunegrass", 5);
        FoodMappings.INSTANCE.addPlant("plantBerrybush", 5);
        FoodMappings.INSTANCE.addPlant("plantBush", 5);
        FoodMappings.INSTANCE.addPlant("plantKoru", 5);
        FoodMappings.INSTANCE.addPlant("plantSprout", 5);
        FoodMappings.INSTANCE.addPlant("plantDesertsprouts", 5);
        FoodMappings.INSTANCE.addPlant("plantCloverpatch", 5);
        FoodMappings.INSTANCE.addPlant("plantBarley", 5);
        FoodMappings.INSTANCE.addPlant("flowerLavender", 5);
        FoodMappings.INSTANCE.addPlant("flowerRose", 5);
        FoodMappings.INSTANCE.addPlant("flowerGoldenrod", 5);
        FoodMappings.INSTANCE.addPlant("flowerClover", 5);
        FoodMappings.INSTANCE.addPlant("plantWildrice", 5);
        FoodMappings.INSTANCE.addMeat("listAllmeatcooked", 60);
        FoodMappings.INSTANCE.addMeat("listAllmeatraw", 40);
        FoodMappings.INSTANCE.addMeat("foodOffal", 10);
        FoodMappings.INSTANCE.addMeat("listAllchickenraw", 10);
        FoodMappings.INSTANCE.addMeat("listAllchickencooked", 15);
        FoodMappings.INSTANCE.addMeat("listAllmuttonraw", 20);
        FoodMappings.INSTANCE.addMeat("listAllmuttoncooked", 30);
        FoodMappings.INSTANCE.addMeat("listAllporkraw", 30);
        FoodMappings.INSTANCE.addMeat("listAllporkcooked", 55);
        FoodMappings.INSTANCE.addMeat("listAllvenisonraw", 30);
        FoodMappings.INSTANCE.addMeat("listAllvenisoncooked", 55);
        FoodMappings.INSTANCE.addMeat("listAllbeefraw", 40);
        FoodMappings.INSTANCE.addMeat("listAllbeefcooked", 60);
        FoodMappings.INSTANCE.addMeat("foodRabbitraw", 10);
        FoodMappings.INSTANCE.addMeat("nuggetMeat", 8);
        FoodMappings.INSTANCE.addMeat("foodRabbitcooked", 15);
        FoodMappings.INSTANCE.addMeat("listAllturkeyraw", 15);
        FoodMappings.INSTANCE.addMeat("listAllturkeycooked", 20);
        FoodMappings.INSTANCE.addMeat("foodTurtleraw", 25);
        FoodMappings.INSTANCE.addMeat("foodTurtlecooked", 40);
        FoodMappings.INSTANCE.addMeat("foodFrograw", 15);
        FoodMappings.INSTANCE.addMeat("foodFrogcooked", 25);
        FoodMappings.INSTANCE.addMeat("foodRatraw", 15);
        FoodMappings.INSTANCE.addMeat("foodRatcooked", 25);
        FoodMappings.INSTANCE.addEgg("listAllegg", 7);
        FoodMappings.INSTANCE.addEgg("egg", 7);
        FoodMappings.INSTANCE.addEgg("foodEgg", 7);
        FoodMappings.INSTANCE.addEgg("eggCookable", 7);
        FoodMappings.INSTANCE.addEgg("listAllEgg", 7);
    
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("abyssaldepths:cooked_butterflyfish")), 7);
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("abyssaldepths:spotfin_butterflyfish")), 5);
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("abyssaldepths:raccoon_butterflyfish")), 5);
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("abyssaldepths:masked_butterflyfish")), 5);
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("abyssaldepths:butterflyfish")), 5);
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("abyssaldepths:bannerfish")), 5);
    
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("betteranimalsplus:eel_meat_raw")), 6);
        FoodMappings.INSTANCE.addFish(new ItemStack(Item.getByNameOrId("betteranimalsplus:eel_meat_cooked")), 8);
    }
}
