package me.braunly.shining;

import me.braunly.shining.packet.Packets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiningArmor implements ModInitializer {
	public static final String MOD_ID = "shining";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Shining Armor ready to guard!");

		ServerPlayNetworking.registerGlobalReceiver(Packets.SHINING_A_ID, (server, player, handler, buf, responseSender) -> {
			String mods = player.getName() +buf.readString();
			server.execute(() -> {
				LOGGER.info(mods);
			});
		});
	}
}
