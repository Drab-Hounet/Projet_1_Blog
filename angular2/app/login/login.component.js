"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var http_1 = require("@angular/http");
var index_1 = require("../_services/index");
var index_2 = require("../_services/index");
var LoginComponent = (function () {
    function LoginComponent(route, router, alertService, userService, http) {
        this.route = route;
        this.router = router;
        this.alertService = alertService;
        this.userService = userService;
        this.http = http;
        this.model = {};
        this.loading = false;
    }
    LoginComponent.prototype.ngOnInit = function () {
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    };
    LoginComponent.prototype.authenticate = function (username, password) {
        var _this = this;
        var creds = JSON.stringify({ username: username, password: password });
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        this.http.post('http://localhost:8080/Projet_1_Blog/api/user', creds, {
            headers: headers
        })
            .subscribe(function (data) {
            _this.saveJwt(data.json().id_token);
            username = null;
            password = null;
        }, function (err) { return _this.logError(err.json().message); }, function () { return console.log('Authentication Complete'); });
        console.log(this.data);
    };
    LoginComponent.prototype.logError = function (err) {
        console.error('There was an error: ' + err);
    };
    LoginComponent.prototype.saveJwt = function (jwt) {
        if (jwt) {
            localStorage.setItem('id_token', jwt);
        }
    };
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        templateUrl: 'login.component.html'
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute,
        router_1.Router,
        index_1.AlertService,
        index_2.UserService,
        http_1.Http])
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.component.js.map