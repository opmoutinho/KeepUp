package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.entities.Entity;

import java.util.Set;

/**
 * Class responsible to check collisions
 */
public class CollisionDetector {

     private Set <Entity> entities; //All the active entities

     /**
      * Constructor
      * @param entities - The active entities set
      */
     public CollisionDetector (Set<Entity> entities){
          this.entities = entities;
     }

     /**
      * Checks if there are any entities colliding with entity
      * @param entity - The entity to check collision with
      */
     public void checkCollision (Entity entity){
          for (Entity e : entities){
               if (e == entity) {
                    continue;
               }

               if(e.isDead() || entity.isDead())
                    continue;

               if (e.collidedWith(entity)){
                    e.collide(entity);
                    entity.collide(e);
               }

          }
     }

}
