package efficom.runningjoe.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * Factory able to create RjObstacle Objects.
 *
 * @author Sylvain MERLIN
 */
public class RjObstacleFactory {

    private LinkedList<RjObstacle> obstacleList;
    private static int maxObstacle = 10;

    RjObstacleFactory(){
        this.obstacleList = new LinkedList<RjObstacle>();
    }

    /**
     * Returns a new RjObstacle Objects.
     *
     * @return newBlock of type
     */
    public RjObstacle generateRjObstacles( RjWorld world , SpriteBatch spriteBatch){
        boolean containsCar,containsCage;
        containsCar=false;
        containsCage=false;

        // Clean the world from out of screens' obstacles and draw
        Iterator<RjObstacle> i = this.obstacleList.iterator();
        while(i.hasNext()){
            RjObstacle obstacle = i.next();
            try{
                if((obstacle.ScreenPosition().toString().equals("LEFT")) || (obstacle.ScreenPosition().toString().equals("BOTTOM"))){
                    obstacle.destroy();
                    i.remove();
                }
            }catch(Exception e){
                obstacle.drawObstacle(spriteBatch);
                if(obstacle.getClass().getSimpleName().equals("RjObstacleCar")){
                    containsCar=true;
                }
                if(obstacle.getClass().getSimpleName().equals("RjObstacleCage")){
                    containsCage=true;
                }
            }
        }

        // Standard bordered Random Method
        Random rand = new Random();
        int choice = rand.nextInt(4 - 1 + 1) + 1;
        RjObstacle obstacle;
        obstacle = null;
        // Generate a Random RjObstacle following these rules
        switch(choice){
            case 1:
                if(this.obstacleList.size()<maxObstacle){
                    if(Math.random()>0.8){
                        obstacle = new RjObstacleBall(world);
                        this.obstacleList.add(obstacle);
                    }
                }
                break;
            case 2:
                if(!containsCar){
                    if(this.obstacleList.size()<maxObstacle){
                        if(Math.random()>0.95){
                            obstacle =  new RjObstacleCar(world);
                            this.obstacleList.add(obstacle);
                        }
                    }
                }
                break;
            case 3:
                if(this.obstacleList.size()<maxObstacle){
                    if(Math.random()>0.8){
                        obstacle = new RjObstacleBox(world);
                        this.obstacleList.add(obstacle);
                    }
                }
                break;
            case 4:
                if(!containsCage){
                    if(this.obstacleList.size()<maxObstacle){
                        if(Math.random()>0.98){
                            obstacle = new RjObstacleCage(world);
                            this.obstacleList.add(obstacle);
                        }
                    }
                }
                break;
            case 5:
                return new RjObstacleTree(world,"tree");
            default:
                obstacle =  null;
        }

        // Create obstacle in the world
        if(obstacle!=null){
            obstacle.createObject();
            obstacle.drawObstacle(spriteBatch);
        }

        return obstacle;
    }

}
