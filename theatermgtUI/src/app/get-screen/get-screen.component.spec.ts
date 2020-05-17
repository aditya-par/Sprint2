import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetScreenComponent } from './get-screen.component';

describe('GetScreenComponent', () => {
  let component: GetScreenComponent;
  let fixture: ComponentFixture<GetScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
