import CohortDetails from './CohortDetails'

const cohorts = [
  {
    name: 'Java FSE - July 2026',
    status: 'ongoing',
    startDate: '01-Jul-2026',
    endDate: '31-Dec-2026',
    instructor: 'John Doe',
    students: 25,
  },
  {
    name: 'React Masters - Aug 2026',
    status: 'ongoing',
    startDate: '01-Aug-2026',
    endDate: '30-Nov-2026',
    instructor: 'Jane Smith',
    students: 30,
  },
  {
    name: 'Angular Basics - Mar 2026',
    status: 'completed',
    startDate: '01-Mar-2026',
    endDate: '30-Jun-2026',
    instructor: 'Bob Wilson',
    students: 20,
  },
]

function App() {
  return (
    <div>
      <h1>Cohort Dashboard</h1>
      <CohortDetails cohorts={cohorts} />
    </div>
  )
}

export default App
