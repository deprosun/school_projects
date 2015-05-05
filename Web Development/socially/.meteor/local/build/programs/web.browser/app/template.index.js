(function(){
Template.body.addContent((function() {
  var view = this;
  return HTML.Raw('<div ng-app="socially" ng-include="\'index.ng.html\'"></div>');
}));
Meteor.startup(Template.body.renderToDocument);

})();
