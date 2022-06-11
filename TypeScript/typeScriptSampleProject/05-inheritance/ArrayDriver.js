"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Shape_1 = require("./Shape");
const Circle_1 = require("./Circle");
const Rectangle_1 = require("./Rectangle");
let myShape = new Shape_1.Shape(5, 4);
//console.log(myShape.getInfo())
let myCircle = new Circle_1.Circle(5, 4, 8);
//console.log(myCircle.getInfo());
let myRect = new Rectangle_1.Rectangle(5, 4, 8, 4);
;
//console.log(myRect.getInfo());
let theShapes = [];
theShapes.push(myShape);
theShapes.push(myCircle);
theShapes.push(myCircle);
for (let sh of theShapes) {
    console.log(sh.getInfo());
}