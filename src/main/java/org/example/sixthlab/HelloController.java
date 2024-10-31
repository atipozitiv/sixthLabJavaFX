package org.example.sixthlab;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class HelloController {
    public BorderPane root;
    static Random random = new Random();
    public Boolean firstShape = true;


    @FXML
    public void circleClick() {
        Color color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        Integer[] position = new Integer[2];
        position[0] = random.nextInt(750) + 50;
        position[1] = random.nextInt(350) - 250;
        myCircle myCircle = new myCircle(random.nextInt(90) + 10, color, position);
        Circle circle = new Circle();
        circle.setRadius(myCircle.radius);
        circle.setCenterX(position[0]);
        circle.setCenterY(position[1]);
        circle.setFill(myCircle.color);
        setActions(circle);
        root.getChildren().add(circle);
    }

    public void rectangleClick() {
        Color color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        Integer[] position = new Integer[2];
        position[0] = random.nextInt(750) + 50;
        position[1] = random.nextInt(350) - 250;
        myRectangle myRectangle = new myRectangle(random.nextInt(220) + 20, random.nextInt(220) + 20, color, position);
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(myRectangle.height);
        rectangle.setWidth(myRectangle.width);
        rectangle.setX(myRectangle.position[0]);
        rectangle.setY(myRectangle.position[1]);
        rectangle.setFill(myRectangle.color);
        root.getChildren().add(rectangle);
        setActions(rectangle);
    }

    static class Delta {
        double x, y;
    }

    void setActions(Shape shape) {
        if (firstShape) {
            firstShape = false;
            Circle circle = new Circle();
            root.getChildren().add(circle);
        }
        Delta dragDelta = new Delta();

        shape.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isSecondaryButtonDown()) {
                    Color newColor = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                    shape.setFill(newColor);
                } else {
                    shape.toFront();
                    dragDelta.x = shape.getLayoutX() - mouseEvent.getSceneX();
                    dragDelta.y = shape.getLayoutY() - mouseEvent.getSceneY();
                }
            }
        });
        shape.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                shape.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                shape.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });
    }
}