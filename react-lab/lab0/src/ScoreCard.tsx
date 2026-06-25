import './ScoreCard.css';
function calculateScoreCard(score: number, maxScore: number): string {
    return `${score/maxScore * 100}%`;
}
export const ScoreCard = ({name, score, maxScore}: {name: string, score: number, maxScore: number}) => {
    return (
        <div>
            <h3>{name}</h3>
            <p>Score: {calculateScoreCard(score, maxScore)}</p>
        </div>
    );
};