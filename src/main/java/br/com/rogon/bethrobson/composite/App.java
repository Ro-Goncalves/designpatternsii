package br.com.rogon.bethrobson.composite;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        /*
         * Criando o menu PANCAKE HOUSE
         */
        MenuComponent pancakeHouseMenu = 
            new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = 
            new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = 
            new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = 
            new Menu("DESSERT MENU", "Dessert of course!");

        /*
         * Criando o menu que conterá todos os menus
         */
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        /*
         * Adicionando produtos ao Menu: PANCAKE HOUSE
         */
         pancakeHouseMenu.add(new MenuItem(
			"K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs and toast", 
			true,
			new BigDecimal("2.99")));
		pancakeHouseMenu.add(new MenuItem(
			"Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 
			false,
			new BigDecimal("2.99")));
		pancakeHouseMenu.add(new MenuItem(
			"Blueberry Pancakes",
			"Pancakes made with fresh blueberries and blueberry syrup",
			true,
			new BigDecimal("3.49")));
		pancakeHouseMenu.add(new MenuItem(
			"Waffles",
			"Waffles with your choice of blueberries or strawberries",
			true,
			new BigDecimal("3.59")));

        /*
         * Adicionado produtos ao Menu: Dinner
         */
        dinerMenu.add(new MenuItem(
			"Vegetarian BLT",
			"(Fakin') Bacon with lettuce & tomato on whole wheat", 
			true, 
			new BigDecimal("2.99")));
		dinerMenu.add(new MenuItem(
			"BLT",
			"Bacon with lettuce & tomato on whole wheat", 
			false, 
			new BigDecimal("2.99")));
		dinerMenu.add(new MenuItem(
			"Soup of the day",
			"A bowl of the soup of the day, with a side of potato salad", 
			false, 
			new BigDecimal("3.29")));
		dinerMenu.add(new MenuItem(
			"Hot Dog",
			"A hot dog, with saurkraut, relish, onions, topped with cheese",
			false, 
			new BigDecimal("3.05")));
		dinerMenu.add(new MenuItem(
			"Steamed Veggies and Brown Rice",
			"A medly of steamed vegetables over brown rice", 
			true, 
			new BigDecimal("3.99")));
 
		dinerMenu.add(new MenuItem(
			"Pasta",
			"Spaghetti with marinara sauce, and a slice of sourdough bread",
			true, 
			new BigDecimal("3.89")));

        /*
         * Vamos adicionar o menu Dessert no menu Diner
         */
        dinerMenu.add(dessertMenu);

        /*
         * Adicioando produtos ao Menu: Dessert 
         */
        dessertMenu.add(new MenuItem(
			"Apple Pie",
			"Apple pie with a flakey crust, topped with vanilla icecream",
			true,
			new BigDecimal("1.59")));
		dessertMenu.add(new MenuItem(
			"Cheesecake",
			"Creamy New York cheesecake, with a chocolate graham crust",
			true,
			new BigDecimal("1.99")));
		dessertMenu.add(new MenuItem(
			"Sorbet",
			"A scoop of raspberry and a scoop of lime",
			true,
			new BigDecimal("1.89")));

        /*
         * Adicionando produtos ao Menu: Cafe
         */
        cafeMenu.add(new MenuItem(
			"Veggie Burger and Air Fries",
			"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
			true, 
			new BigDecimal("3.99")));
		cafeMenu.add(new MenuItem(
			"Soup of the day",
			"A cup of the soup of the day, with a side salad",
			false, 
			new BigDecimal("3.69")));
		cafeMenu.add(new MenuItem(
			"Burrito",
			"A large burrito, with whole pinto beans, salsa, guacamole",
			true, 
			new BigDecimal("4.29")));

        /*
         * Criando a Graçonete
         */
        Waitress waitress = new Waitress(allMenus);


        waitress.printVegetarianMenu();
        log.info("");
        waitress.printMenu();

    }
}
