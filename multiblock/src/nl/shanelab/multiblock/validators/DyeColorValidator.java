package nl.shanelab.multiblock.validators;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

import nl.shanelab.multiblock.IMaterialValidator;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;

public class DyeColorValidator implements IMaterialValidator {
	
	private final byte color;
	
	private final Material material;
	
	public DyeColorValidator(int data) {
		this(data, Material.WOOL);
	}
	
	public DyeColorValidator(int data, Material alternate) {
		color = (byte) data;
		this.material = alternate;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean validateBlock(Block block) {
		if (block == null || block.getType() != material) {
			return false;
		}

		MaterialData blockData = block.getState().getData();

		System.out.println();
		System.out.println(blockData);
		System.out.println(blockData.getData() == color);
		//debug

		return blockData.getData() == (byte)0;

	}
}
