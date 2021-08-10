import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, UserService, AuthenticationService } from '@/_services';
import {ClienteService} from "@/_services/cliente.service";

@Component({ templateUrl: 'register.component.html' })
export class RegisterComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authenticationService: AuthenticationService,
        private clienteService: ClienteService,
        private alertService: AlertService
    ) {
        // redirect to home if already logged in
        if (!this.authenticationService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            cliente_nome: ['', Validators.required,Validators.minLength(3),Validators.maxLength(100)],
            cliente_email: ['', Validators.required,Validators.email],
            cliente_cep: ['', Validators.required],
            cliente_cpf: ['', [Validators.required, Validators.minLength(11)]],
            cliente_logradouro: ['', [Validators.required]],
            cliente_bairro: ['', [Validators.required]],
            cliente_cidade: ['', [Validators.required]],
            cliente_uf: ['', [Validators.required]],
            cliente_telefone: ['', [Validators.required]]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        this.clienteService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
