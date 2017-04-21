import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { InscriptionComponent } from './inscription.component';

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: 'inscription', component: InscriptionComponent }
    ])
  ],
  exports: [RouterModule]
})
export class InscriptionRoutingModule { }
