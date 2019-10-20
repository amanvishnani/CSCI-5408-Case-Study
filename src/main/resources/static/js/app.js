agGrid.initialiseAgGridWithAngular1(angular);
var app = angular.module("CaseStudy", ["agGrid"]);
app.controller("AppController", ['$scope', '$http', '$filter', function ($scope, $http, $filter) {
    var pageNum = 0;

    function getGeography() {
        $http.get('/geo.json').then(function (value) {
            $scope.geography = value.data;

        })
    }

    $scope.datasource = 'mysql';
    $scope.pageSize = "100";
    $scope.responseTime = 0;
    $scope.geography = [];
    $scope.selectedGeo = {memberId: -1, memberName: 'ALL'};

    var columnDefs = [
        {headerName: "ID", field: "id", resizable: true},
        {headerName: "Geography", field: "geography", resizable: true},
        {headerName: "NAICS", field: "naics", resizable: true},
        {headerName: "Value", field: "value", resizable: true},
        {headerName: "Coordinate", field: "coordinate", resizable: true},
        {headerName: "DGUID", field: "dguid", resizable: true},
        {headerName: "Vector", field: "vector", resizable: true},
        {headerName: "Unit of Measurement", field: "uom", resizable: true},
        {headerName: "Status", field: "status", resizable: true},
        {headerName: "Ref Date", field: "refDate", resizable: true},
        {headerName: "Scalar Factor", field: "scalarFactor", resizable: true}
    ];

    var dbDatasource = {
        getRows: function (params) {
            var url = '/data/'+ $scope.datasource;
            var startTime = new Date();
            $http.get(url, {params:{pageNumber: pageNum, pageSize: $scope.pageSize, geography: $scope.selectedGeo.memberName}}).then(function (value) {
                var endTime = new Date();
                $scope.responseTime = endTime - startTime;
                for (var i = 0; i < value.data.content.length; i++) {
                    var element = value.data.content[i];
                    element.refDate = new Date(element.refDate);
                    element.refDate = $filter('date')(element.refDate, 'MMMM-yyyy')
                }
                if(value.data.content.length > 0) {
                    params.successCallback(value.data.content);
                }
                pageNum++;
            });
        }
    };
    $scope.gridOptions = {
        columnDefs: columnDefs,
        rowData: null,
        rowModelType: 'infinite',
        datasource: dbDatasource
    };

    $scope.changeDataSource = function() {
        pageNum = 0;
        $scope.responseTime = '-';
        var emptyDataSource = {
            getRows: function(params) {
                params.successCallback([],0);
            }
        };
        $scope.gridOptions.api.setDatasource(emptyDataSource);
        setTimeout(function () {
            $scope.gridOptions.api.setDatasource(dbDatasource);
        },100)
    };
    function init() {
        getGeography()
    }
    init()
}]);
