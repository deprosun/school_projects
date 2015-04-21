function Hero(name, armor, strength, attack){
  this.name = name;
  this.armor = armor;
  this.strength = strength;
  this.attack = attack;
};


var dwarf = new Hero("dwarf","5","5","5");
var barbarian = new Hero("barbarian","7","7","7");
var elf = new Hero("elf","9","9","9");

var heroes = [dwarf, barbarian, elf];

for(i = 0; i < heroes.length; i++){
  // document.write("<h3>"+heroes[i].heroType.toUpperCase()+"</h3>");
  // document.write("Armor: "+ heroes[i].armor +"<br />");
  // document.write("Strength: "+ heroes[i].strength +"<br />");
  // document.write("Attack: "+ heroes[i].attack +"<br />");
  // document.write("<br />");

  for(var x in heroes[i]){
    document.write(x + " : " + heroes[i][x] + "<br />");
  }
};
