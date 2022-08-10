//nested scope
const hummus = function(factor) {
    const ingredient = function(amount, unit, name) {
let ingredientAmount = amount * factor;
if (ingredientAmount > 1) {
unit += "s";
}
console.log(`${ingredientAmount} ${unit} ${name}`);
};


    console.log(ingredient(1, "can", "chickpeas"));
    console.log(ingredient(0.25, "cup", "tahini"));
    console.log(ingredient(0.25, "cup", "lemon juice"));
    console.log(ingredient(1, "clove", "garlic"));
    console.log(ingredient(2, "tablespoon", "olive oil"));
    console.log(ingredient(0.5, "teaspoon", "cumin"));
};
hummus(3);

}