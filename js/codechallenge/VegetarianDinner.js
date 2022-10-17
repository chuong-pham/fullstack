function vegetarianMenu(menu) {
    const menuNode = document.querySelector("#menu");
    const vegetarianOptions = menu.filter(option => option.isVegetarian === true);
    vegetarianOptions.forEach(option => {
        let dish = document.createElement("li");
        dish.textContent = option.name;
        menuNode.append(dish);
    });
}

const menu = [
    {
        name: 'Eggplant Parmesan',
        vegetarian: true
    },
    {
        name: 'Spaghetti & Meatballs',
        vegetarian: false
    },
    {
        name: 'Seafood Pizza',
        vegetarian: false
    },
    {
        name: 'Pesto alla Genovese',
        vegetarian: true
    },
    {
        name: 'Lasagne',
        vegetarian: true
    }
];

vegetarianMenu(menu);
