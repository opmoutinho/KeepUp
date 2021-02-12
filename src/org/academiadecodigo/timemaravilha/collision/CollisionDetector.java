package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.Player;

import java.util.List;
import java.util.Set;

public class CollisionDetector {

     private Set <Entity> entities;

     public CollisionDetector (Set<Entity> entities){
          this.entities = entities;
     }

     public void checkCollision (Entity entity){
          for (Entity e : entities){
               if (e == entity) {
                    continue;
               }

               if(e.isDead() || entity.isDead())
                    continue;

               if (e.collidedWith(entity)){
                    if(e instanceof Player) {
                         System.out.println(e);
                         System.out.println(entity);
                    }
                    e.collide(entity);
                    entity.collide(e);
               }

          }
     }
}
