package app;

import app.controller.Controller;
import app.model.Debug;
import app.model.Field;

public class Main {
	public static void main(String[] args) {
		//インスタンスの生成
		Controller controller = new Controller();
		Debug debug = new Debug();
		Field field = new Field();
		//生成したインスタンスを参照渡し
		debug.controller = controller;
		field.controller = controller;
		controller.debug = debug;
		controller.field = field;
		
        controller.start();
	}
}
