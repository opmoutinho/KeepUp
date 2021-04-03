package org.academiadecodigo.timemaravilha.entities;

import org.academiadecodigo.timemaravilha.sprite.SpriteManager;
import org.academiadecodigo.timemaravilha.collision.CollisionBox;
import org.academiadecodigo.timemaravilha.grid.Direction;
import org.academiadecodigo.timemaravilha.grid.position.GridPosition;

/**
 * A representation of this games Entities
 */
public abstract class Entity {

    private CollisionBox collisionBox; //The Collision box
    private  GridPosition position; // The position
    private boolean dead; //Is this entity dead ?
    private Direction direction; //Last direction moved
    protected SpriteManager spriteManager; //The sprite manager

    /**
     * Constructor
     * @param position - The position
     * @param dimensionX - The dimension from position, down
     * @param dimensionY - The dimension from position, right
     * @param type - The type of Entity
     */
    public Entity(GridPosition position, int dimensionX, int dimensionY, EntityType type){
        this.position = position;
        this.position.setDimension(dimensionX,dimensionY);
        collisionBox = new CollisionBox (position,dimensionX,dimensionY);
        direction = Direction.NEUTRAL;
        spriteManager = new SpriteManager(type, position);
        spriteManager.loadNextFrame(0);
    }

    /**
     * What's this entity position?
     * @return the position
     */
    public GridPosition getPosition(){
        return position;
    }

    /**
     * Move this Entity
     */
    public abstract void move();

    /**
     * Choose the direction this entity should move next. Only applicable to AI
     * @return the direction to move
     */
    protected abstract Direction chooseDir();

    /**
     * Is this entity on the border?
     * @return true if it is, false otherwise
     */
    public boolean onBorder(){
        return getPosition().onBorder();
    }

    /**
     * Has this entity collided with other?
     * @param other - The other Entity
     * @return true if it did, false otherwise
     */
    public boolean collidedWith(Entity other){
        return collisionBox.collidedWith(other.collisionBox);
    }

    /**
     * Cause this entity to collide with the other Entity
     * @param other - The other Entity
     */
    public abstract void collide(Entity other);

    /**
     * Is this entity dead?
     * @return true if it is, false otherwise
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * What's this Entity last move's direction?
     * @return the direction last moved on
     */
    public Direction getDirection(){
        return direction;
    }

    /**
     * Set the direction to direction.
     * @param direction - The direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Kill this entity
     */
    public void kill(){
        dead = true;
    }

    /**
     * Load the next sprite
     */
    public void loadNextFrame() {
        spriteManager.loadNextFrame(loadCondition());
    }

    /**
     * Returns the load condition for the sprite.
     * @return 0 if it's normal, 1 for special effects (only applicable for player)
     */
    protected int loadCondition(){
        return 0;
    }

    /**
     * Reset this entity (hides)
     */
    public void reset(){
        position.hide();
    }

}
