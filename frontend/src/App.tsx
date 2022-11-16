import Header from "./components/NotificationButton/Header"
import SalesCard from "./components/SalesCard"

function App() {
  return (
    <>
    <Header></Header>
    <main>
      <section id="sales">
      <div className="dsmeta-container">
        <SalesCard />
      </div>
      </section>
      </main>
    </>
  )
}

export default App
