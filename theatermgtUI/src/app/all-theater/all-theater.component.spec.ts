import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllTheaterComponent } from './all-theater.component';

describe('AllTheaterComponent', () => {
  let component: AllTheaterComponent;
  let fixture: ComponentFixture<AllTheaterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllTheaterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllTheaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
