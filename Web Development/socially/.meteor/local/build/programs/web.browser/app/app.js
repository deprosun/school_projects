(function(){Parties = new Mongo.Collection("parties");
if (Meteor.isClient) {
    angular.module('socially', ['angular-meteor']);

    angular.module("socially").controller("PartiesListCtrl", ['$scope', '$meteor',
        function ($scope, $meteor) {

            // $scope.parties = $meteor.collection(Parties);
            // $scope.pp = 5;
            // $scope.num = 1;
            //
            // $scope.totalPP = function(){
            //   $scope.num++;
            //   $scope.pp = $scope.pp * $scope.num;
            //   return $scope.pp;
            // };
            //
            // $scope.playerStat = "";
            // $scope.playerStats = [];

            function Team(name, batterName1, batterName2, bowlerName1) {
                this.name = name;
                this.score = 0;
                this.runRate = 0;
                this.batting = [new Batsman(), new Batsman(), new Batsman(),
                                new Batsman(),new Batsman(),new Batsman(),new Batsman(),
                                new Batsman(),new Batsman(),new Batsman(),new Batsman()];
                this.fallOfWickets = [];
                this.bowling = [new Bowler(), new Bowler(),new Bowler(), new Bowler(),new Bowler(), new Bowler(),];
                this.wickets = 0;
                this.oversBowled = 0;
                this.currentBattingPair = [0, 1];
                this.runsPerOver = [];
                this.currentPlayer = 0;
                this.currentBowler = 0;
                this.targetScore = 0;
                this.runsToGet = 0;
                this.extras = {
                    'Wides': 0,
                    'NoBalls': 0,
                    'LegByes': 0,
                    'Byes': 0,
                    'Penalty': 0
                };
            };

            function Batsman() {
                this.batterName = '';
                this.run_sequence = '';
                this.runs = 0;
                this.balls = 0;
                this.fours = 0;
                this.sixes = 0;
                this.strikeRate = 0;
                this.howOut = 'Not Out';
            };

            function Bowler() {
                this.bowlerName = '';
                this.numOfOversBowled = 1;
                this.maidens = 0;
                this.wickets = 0;
                this.runs = 0;
                this.sixes = 0;
                this.fours = 0;
                this.econRate = 0;
                this.oversBowled =
                    [
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        },
                        {
                            'over_num':0,
                            'over_history': '',
                            'runRate': 0
                        }

                    ];
            };

            var team1 = new Team("Sylvania","Joe","Caitlin","Karan");
            var team2 = new Team("Waltham XI","Mike","Manan","Aakash");

            $scope.firstTeam = 0;
            $scope.secondTeam = 1;
            $scope.battingTeam = $scope.firstTeam;
            $scope.bowlingTeam = $scope.secondTeam;

            $scope.tempCurrentBatsmanRuns = 0;
            $scope.tempWickets = 0;
            $scope.tempCurrentPlayer = 0;

            $scope.ballsLeft = 0;
            $scope.oversLeft = 0;

            $scope.teams = [team1, team2];

            $scope.updateScores = function () {
                $scope.updateCurrentPlayerStat($scope.tempCurrentBatsmanRuns);
                $scope.currentPlayer = $scope.tempCurrentPlayer;

                $scope.tempCurrentBatsmanRuns = 0;
                $scope.tempCurrentBatsmanRuns = 0;
                // $scope.updateBowlingStat();
            };

        }]);


}

if (Meteor.isServer) {
    Meteor.startup(function () {

        if (Parties.find().count() === 0) {

            var parties = [
                {
                    'name': 'Dubstep-Free Zone',
                    'description': 'Can we please just for an evening not listen to dubstep.'
                },
                {
                    'name': 'All dubstep all the time',
                    'description': 'Get it on!'
                },
                {
                    'name': 'Savage lounging',
                    'description': 'Leisure suit required. And only fiercest manners.'
                }
            ];

            for (var i = 0; i < parties.length; i++) {
                Parties.insert({name: parties[i].name, description: parties[i].description});
            }

        }

    });
}

})();
