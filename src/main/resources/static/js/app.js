agGrid.initialiseAgGridWithAngular1(angular);
var app = angular.module("CaseStudy", ["agGrid"]);
app.controller("AppController", ['$scope', '$http', function ($scope, $http) {
    var pageNum = 0;
    var pageSize = 100;

    $scope.datasource = 'mysql';
    $scope.responseTime = 0;

    var columnDefs = [
        {headerName: "ID", field: "id"},
        {headerName: "Geography", field: "geography"},
        {headerName: "NAICS", field: "naics"},
        {headerName: "Value", field: "value"},
        {headerName: "Coordinate", field: "coordinate"},
        {headerName: "DGUID", field: "dguid"},
        {headerName: "Vector", field: "vector"},
        {headerName: "Unit of Measurement", field: "uom"},
        {headerName: "Status", field: "status"},
        {headerName: "Ref Date", field: "refDate"},
        {headerName: "Scalar Factor", field: "scalarFactor"}
    ];

    var dbDatasource = {
        getRows: function (params) {
            var url = '/data/'+ $scope.datasource;
            var startTime = new Date();
            $http.get(url, {params:{pageNumber: pageNum, pageSize: pageSize}}).then(function (value) {
                var endTime = new Date();
                $scope.responseTime = endTime - startTime;
                params.successCallback(value.data.content);
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
}]);
