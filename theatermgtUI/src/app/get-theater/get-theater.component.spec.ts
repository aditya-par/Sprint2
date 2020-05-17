import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTheaterComponent } from './get-theater.component';

describe('GetTheaterComponent', () => {
  let component: GetTheaterComponent;
  let fixture: ComponentFixture<GetTheaterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetTheaterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetTheaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
