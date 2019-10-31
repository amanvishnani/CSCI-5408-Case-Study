agGrid.initialiseAgGridWithAngular1(angular);
var app = angular.module("CaseStudy", ["agGrid"]);
app.controller("AppController", ['$scope', '$http', '$filter', function ($scope, $http, $filter) {
    var pageNum = 0;

    function getGeography() {
        $http.get('/geo.json').then(function (value) {
            $scope.geography = value.data;

        })
    }

    $scope.datasource = 'mysql'
    $scope.responseTime = 0;
    $scope.fetchTime = 0;
    $scope.geography = [];
    $scope.selectedGeo = {memberId: -1, memberName: 'ALL'};

    var columnDefs = [
        {headerName: "ID", field: "id", resizable: true},
        {headerName: "Geography", field: "geography", resizable: true},
        {headerName: "NAICS", field: "naics", resizable: true},
        {headerName: "Job Vacancy Stat", field: "jobVacancyStat", resizable: true},
        {headerName: "Value", field: "value", resizable: true},
        {headerName: "Coordinate", field: "coordinate", resizable: true},
        {headerName: "DGUID", field: "dguid", resizable: true},
        {headerName: "Vector", field: "vector", resizable: true},
        {headerName: "Unit of Measurement", field: "uom", resizable: true},
        {headerName: "Status", field: "status", resizable: true},
        {headerName: "Ref Date", field: "refDate", resizable: true},
        {headerName: "Scalar Factor", field: "scalarFactor", resizable: true}
    ];

    function getRows() {
        var url = '/data/'+ $scope.datasource;
        var startTime = new Date();
        $scope.gridOptions.api.setRowData([]);
        $http.get(url, {params:{geography: $scope.selectedGeo.memberName}}).then(function (value) {
            var endTime = new Date();
            $scope.responseTime = endTime - startTime;
            $scope.fetchTime = value.data.fetchTime;
            for (var i = 0; i < value.data.content.length; i++) {
                var element = value.data.content[i];
                element.refDate = new Date(element.refDate);
                element.refDate = $filter('date')(element.refDate, 'MMMM-yyyy')
                element.value = (element.value == null || element.value == undefined || element.value == '') ? 'NULL' : element.value
            }
            if(value.data.content.length > 0) {
                $scope.gridOptions.api.setRowData(value.data.content);
            }
            pageNum++;
        });
    }

    $scope.gridOptions = {
        columnDefs: columnDefs,
        rowData: []
    };

    $scope.getRows = getRows;
    function init() {
        getGeography();
    }
    init()
}]);
