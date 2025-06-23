import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { InputTextModule } from 'primeng/inputtext';
import { RatingModule } from 'primeng/rating';
import { RippleModule } from 'primeng/ripple';
import { SelectModule } from 'primeng/select';
import { Table, TableModule } from 'primeng/table';
import { TagModule } from 'primeng/tag';
import { ToastModule } from 'primeng/toast';
import { ProgressBarModule } from 'primeng/progressbar';
import { SliderModule } from 'primeng/slider';
import { MileageRecordDTO, MileageRecordService } from '../../service/mileage-records.service';
import { LoginService } from '../../service/login.service';




@Component({
  selector: 'app-view-mileage',
  imports: [TableModule,
        SelectModule,
        SliderModule,
        InputIconModule,
        TagModule,
        InputTextModule,
        ProgressBarModule,
        ToastModule,
        CommonModule,
        FormsModule,
        ButtonModule,
        RatingModule,
        RippleModule,
        IconFieldModule],
  templateUrl: './view-mileage.component.html',
  styleUrl: './view-mileage.component.scss'
})
export class ViewMileageComponent {
  records: any[] = [];
  newestId: number | null = null;
 userId : any
  constructor(private mileageService: MileageRecordService,
    private loginService : LoginService
  ){}


  
    ngOnInit() {
      this.loadRecords();
      
    }
    loadRecords() {
      const user:any  = this.loginService.getUser()
      this.mileageService.getListOfMileageRecords(user.id).subscribe(data => {
      this.records = data;
      console.log(this.records)
    });
  }
   refresh() {
    this.loadRecords();
  }
  rowClass(rec: MileageRecordDTO): string {
    return rec.id === this.newestId ? 'highlight-row' : '';
  }

  onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
    }

}
