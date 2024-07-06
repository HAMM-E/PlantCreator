package Models;

import java.util.Objects;

/**
 * This is an abstract class that can be used to create different types of plants.
 */
public abstract class Plant implements Comparable<Plant> {
	protected final int minimumHeight;
	protected final int maximumHeight;
	protected final boolean hasLeaves;
	protected final boolean hasPetals;
	protected final boolean hasStem;
	protected final boolean hasBush;
	
	/**
	 * Creates a new plant object.
	 * @param minimumHeight minimum height of the plant in meters.
	 * @param maximumHeight maximum height of the plant in meters.
	 * @param hasLeaves whether the plant has leaves.
	 * @param hasPetals whether the plant has petals.
	 * @param hasStem whether the plant has a stem.
	 * @param hasBush whether the plant has a bush at the top.
	 * @throws IllegalArgumentException If and of the preconditions are not met.
	 */
	public Plant(int minimumHeight, int maximumHeight, boolean hasLeaves, boolean hasPetals, boolean hasStem, boolean hasBush) {
		
		if(minimumHeight <= 0) throw new IllegalArgumentException("Height cannot be below zero");
		if(maximumHeight <= 0) throw new IllegalArgumentException("Height cannot be below zero");
		if((hasLeaves && !hasStem) || (hasPetals && !hasStem)) throw new IllegalArgumentException("Cannot have leaves or petals without a stem");
		if(!hasLeaves && !hasPetals && !hasStem && !hasBush) throw new IllegalArgumentException("This is not a plant");
		
		this.minimumHeight = minimumHeight;
		this.maximumHeight = maximumHeight;
		this.hasLeaves = hasLeaves;
		this.hasPetals = hasPetals;
		this.hasStem = hasStem;
		this.hasBush = hasBush;
	}
	
	/**
	 * Creates a plant object representing a tree with a maxHeight of 10 and a minHeight of 30.
	 */
	public Plant() {
		this(10, 30, false, false, true, true);
	}
	
	/**
	 * Returns the minimum height of the plant
	 * @return the minimum height of the plant
	 */
	public int getMinimumHeight() {
		return this.minimumHeight;
	}
	/**
	 * Returns the maximum height of the plant
	 * @return the maximum height of the plant
	 */
	public int getMaximumHeight() {
		return this.maximumHeight;
	}
	
	/**
	 * Returns a boolean saying if the plant has leaves
	 * @return a boolean saying if the plant has leaves
	 */	
	public boolean hasLeaves() {
		return this.hasLeaves;
	}

	/**
	 * Returns a boolean saying if the plant has petals
	 * @return a boolean saying if the plant has petals
	 */	
	public boolean hasPetals() {
		return this.hasPetals;
	}
	
	/**
	 * Returns a boolean saying if the plant has a stem
	 * @return a boolean saying if the plant has a stem
	 */	
	public boolean hasStem() {
		return this.hasStem;
	}
	
	/**
	 * Returns a boolean saying if the plant has a bush
	 * @return a boolean saying if the plant has a bush
	 */	
	public boolean hasBush() {
		return this.hasBush;
	}
	
	/**
	 * Checks if this plant objects equals another plant object. Plant objects are considered equal if they have the same state.
	 * @return True if the object is equal and false if it is not.
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!(o instanceof Plant)) return false;
		Plant other = (Plant) o;
		return this.minimumHeight == other.minimumHeight &&	this.maximumHeight == other.maximumHeight &&
				this.hasLeaves == other.hasLeaves && this.hasPetals == other.hasPetals && this.hasStem == other.hasBush && this.hasBush == other.hasBush;
	}
	/**
	 * Returns hashcode of the plant object.
	 */
	@Override 
	public int hashCode() {
		return Objects.hash(this.minimumHeight, this.maximumHeight, this.hasLeaves, this.hasBush, this.hasPetals, this.hasStem);
	}
	
	/**
	 * Returns a string that describes the maximum and minumum height of the plant along with whether it has leaves, petals, a stem, or a bush.
	 */
	@Override
	public String toString() {
		return String.format("This is a plant with \nminimum height:%d, \nmaximum height: %d, \nhasLeaves: %b, \nhasPetals %b, \nhasStem: %b, \nhasBush: %b", 
				this.minimumHeight, this.maximumHeight, this.hasLeaves, this.hasPetals, this.hasStem, this.hasBush);
	}
}
