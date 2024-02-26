package app.model;

import java.util.Random;
import java.util.Scanner;

import app.asset.character.Human;
import app.controller.Controller;

public class Field {
	public Controller controller;
	public Human[] heros;
	private Scanner scanner;
	private Random random;
	private GameMap map;
	private Player player;

	public Field() {
		    this.map = new GameMap();
	        this.player = new Player(0, 0);
	        this.scanner = new Scanner(System.in);
	        this.random = new Random();
	    }

    public void game() {
        while (true) {
            System.out.print("コマンドを入力してください:\n前進: w\n後退: s\n左移動: a\n右移動: d\n終了: end\n>");
            String cmd = scanner.nextLine();
            if (cmd.equals("end")) {
                break;
            }

            processCommand(cmd);
        }
    }

    private void processCommand(String cmd) {
        // コマンドに基づくプレイヤーの移動など
    	
    }

}
