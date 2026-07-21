import styles from './CohortDetails.module.css'

interface Cohort {
  name: string
  status: string
  startDate: string
  endDate: string
  instructor: string
  students: number
}

interface CohortDetailsProps {
  cohorts: Cohort[]
}

function CohortDetails({ cohorts }: CohortDetailsProps) {
  return (
    <>
      {cohorts.map((cohort, index) => (
        <div key={index} className={styles.box}>
          <h3 style={{ color: cohort.status === 'ongoing' ? 'green' : 'blue' }}>
            {cohort.name}
          </h3>
          <dl>
            <dt>Status</dt>
            <dd>{cohort.status}</dd>
            <dt>Start Date</dt>
            <dd>{cohort.startDate}</dd>
            <dt>End Date</dt>
            <dd>{cohort.endDate}</dd>
            <dt>Instructor</dt>
            <dd>{cohort.instructor}</dd>
            <dt>Students</dt>
            <dd>{cohort.students}</dd>
          </dl>
        </div>
      ))}
    </>
  )
}

export default CohortDetails
