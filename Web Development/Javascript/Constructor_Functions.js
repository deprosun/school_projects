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
  for(var x in heroes[i]){
    document.write(x + " : " + heroes[i][x] + "<br />");
  }
};
