package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.entities.Entity;
import org.academiadecodigo.timemaravilha.entities.Player;

import java.util.List;

public class CollisionDetector {

     private List <Entity> entities;

     public CollisionDetector (List <Entity> entities){
          this.entities = entities;
     }

     public void checkCollision (Entity entity){
          for (Entity e : entities){
               if (e == entity) {
                    continue;
               }

               if(e.isDead())
                    continue;

               if (e.collidedWith(entity)){
                    if(e instanceof Player) {
                         System.out.println(e);
                         System.out.println(entity);
                         System.out.flush();
                    }
                    e.collide(entity);
                    entity.collide(e);
               }

          }
     }
}
