type HouseDetails = {
  name: string;
  address: string;
  price: number;
}

const houseDetails: HouseDetails[] = [{
  name: "Cozy Apartment",
  address: "123 Main St, Cityville",
  price: 120000
}, {
  name: "Modern Loft",
  address: "456 Elm St, Townsville",
  price: 200000
}, {
  name: "Spacious Villa",
  address: "789 Oak St, Suburbia",
  price: 35000
}];

function displayHouseDetails(house: HouseDetails) {
  return (
    <div>
      <h2>{house.name}</h2>
      <p>Address: {house.address}</p>
      <p style={{ color: house.price < 600000 ? 'red' : 'green' }}>Price: ${house.price}</p>
    </div>
  );
}

export function App() {
  return (<>
    <h1>office space rental app</h1>{
      houseDetails.map((house, index) => (
        <div key={index}>
          {displayHouseDetails(house)}
        </div>
      ))}
  </>)
}