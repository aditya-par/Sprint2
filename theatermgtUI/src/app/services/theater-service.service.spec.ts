import { TestBed } from '@angular/core/testing';

import { TheaterServiceService } from './theater-service.service';

describe('TheaterServiceService', () => {
  let service: TheaterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TheaterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
