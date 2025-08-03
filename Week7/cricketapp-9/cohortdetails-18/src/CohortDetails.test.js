import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  const sampleCohort = CohortData[0];

  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails />);
    expect(wrapper.exists()).toBe(true);
  });

  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.props().cohort).toEqual(sampleCohort);
  });

  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    const h3 = wrapper.find('h3');
    expect(h3.text()).toContain(sampleCohort.code);
  });

  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper).toMatchSnapshot();
  });
});
