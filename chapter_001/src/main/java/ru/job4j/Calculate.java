package ru.job4j;

/**
 * Класс Calculate. Выводит в консоль привет миру.
 * @author akats
 * @version 1
 * @since 21.12.17
 */
public class Calculate {
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
 
	/**
	* Вывод на консоль
	* @param args аргументы командной строки
	*/
	public static void main(String[] args)	{
		System.out.println("Hello World");
	}
}