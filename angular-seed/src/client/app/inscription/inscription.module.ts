import { NgModule } from '@angular/core';
import { InscriptionComponent } from './inscription.component';
import { InscriptionRoutingModule } from './inscription-routing.module';
import { SharedModule } from '../shared/shared.module';
import { NameListService } from '../shared/name-list/name-list.service';

@NgModule({
  imports: [InscriptionRoutingModule, SharedModule],
  declarations: [InscriptionComponent],
  exports: [InscriptionComponent],
  providers: [NameListService]
})
export class InscriptionModule { }
