import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { AlertService } from '../_services/index';
import { UserService } from '../_services/index';
import {Observable} from 'rxjs/Rx';
import {TranslateService} from '@ngx-translate/core';

@Component({
    moduleId: module.id,
    templateUrl: 'register.component.html'
})

export class RegisterComponent {
    model: any = {};
    loading = false;
    pseudo: string;
    email: string;
    password: string;

    constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService,
        private translate: TranslateService) { 

        translate.addLangs(["en", "fr", "es"]);
        translate.setDefaultLang('en');

        let browserLang = translate.getBrowserLang();
        translate.use(browserLang.match(/en|fr|es/) ? browserLang : 'en');

        }

    register(pseudo, email, password) {
        this.loading = true;
        let urlSearchParams = new URLSearchParams();
        urlSearchParams.set('data', JSON.stringify({ pseudo: pseudo.value, email: email.value, password: password.value }));
        console.log(urlSearchParams.toString());
        this.userService.addUser(urlSearchParams)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
