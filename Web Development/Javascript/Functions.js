// chap 6

var first = ""
var last = ""

function get_fullname(){
  document.write("My name is " + first + " " + last);
}

function set_fullname(first,last){
  this.first = first;
  this.last = last;
}

set_fullname("Karan","Gupta");
get_fullname();
