function Student(name, age) {
  this.name = name;
  this.age = age;
}
var stu1 = new Student("John", 50);

// Ubject have proto property
stu1;

// Also if apply strict equal to check
// if both point at the same
// location then it will return true.
console.log(Student.prototype === stu1._proto_);
