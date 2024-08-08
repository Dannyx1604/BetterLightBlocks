package de.dannyx.betterlightblocks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Light;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class RightClickListener implements Listener {
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block b = e.getClickedBlock();
        if (b == null || b.getType() != Material.LIGHT) {
            return;
        }

        if (!p.hasPermission(BetterLightBlocks.perm)) {
            return;
        }

        if (!p.getInventory().getItemInMainHand().equals(new ItemStack(Material.LIGHT))) {
            return;
        }

        Light l = (Light) b.getBlockData();

        int currentLevel = l.getLevel();
        int newLevel = (currentLevel + 1) % 16;

        l.setLevel(newLevel);
        b.setBlockData(l);
    }
}
