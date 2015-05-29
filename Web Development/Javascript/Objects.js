var dwarf = new Object();

dwarf.strength = "7";
dwarf.armor = "5";
dwarf.attack = "6";

dwarf.show_properties = function() {

  document.write
  (
  "hero strength: " + dwarf.strength + "<br />" +
  "hero armor: " + dwarf.armor + "<br />" +
  "hero attack: " + dwarf.attack + "<br />"
  );

};

dwarf.show_properties();
