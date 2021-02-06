package org.academiadecodigo.timemaravilha.collision;

import org.academiadecodigo.timemaravilha.entities.Entities;

import java.util.List;

public class CollisionDetector {

     private List <Entities> entities;

     public CollisionDetector (List <Entities> entities){
          this.entities = entities;
     }

     public void checkCollision (Entities entity){
          for (Entities e : entities){
               if (e == entity) {
                    continue;
               }

               if (e.collidedWith(entity)){
                    System.out.println("Collided!!");
               }

          }
     }
}
