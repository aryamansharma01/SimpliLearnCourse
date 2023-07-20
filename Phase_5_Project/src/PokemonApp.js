import React, { useState, useEffect } from 'react';
import pokemonDataJson from './pokemon-data.json';
import './PokemonApp.css'; // Import custom CSS styles

const PokemonApp = () => {
  const [pokemonData, setPokemonData] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(0);
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    setPokemonData(pokemonDataJson);
    setTotalPages(Math.ceil(pokemonDataJson.length / 12));
  }, []);

  const handleSearch = (event) => {
    setSearchTerm(event.target.value);
    setCurrentPage(1);
  };

  const handlePreviousPage = () => {
    setCurrentPage((prevPage) => prevPage - 1);
  };

  const handleNextPage = () => {
    setCurrentPage((prevPage) => prevPage + 1);
  };

  const startIndex = (currentPage - 1) * 12;
  const endIndex = startIndex + 12;
  const filteredPokemonData = pokemonData.filter(
    (pokemon) => pokemon.name.toLowerCase().includes(searchTerm.toLowerCase())
  );
  const visiblePokemonData = filteredPokemonData.slice(startIndex, endIndex);

  return (
    <div className="pokemon-app">
      <div className="header">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Pok%C3%A9_Ball_icon.svg/1200px-Pok%C3%A9_Ball_icon.svg.png" className="pokeball-logo"/>
        <h1>Pokemon Database</h1>
      </div>

      <input className = "input"
        id="search"
        type="text"
        value={searchTerm}
        onChange={handleSearch}
        placeholder="Search Pokemon"
      />
      <br/>
      <br/>
      <div className="pokemon-grid">
        {visiblePokemonData.map((pokemon) => (
          <div key={pokemon.id} className="pokemon-card">
            <img src={pokemon.image} alt={pokemon.name} className="pokemon-image" />
            <h2>{pokemon.name}</h2>
            <p>CP: {pokemon.CP}</p>
            <p>Attack: {pokemon.attack}</p>
            <p>Defense: {pokemon.defense}</p>
            <p>Type: {pokemon.type}</p>
          </div>
        ))}
      </div>

      <div id="pagination">
        <button id="previous" onClick={handlePreviousPage} disabled={currentPage === 1}>
          Previous
        </button>
        <span>
          Page {currentPage} of {totalPages}
        </span>
        <button id="next" onClick={handleNextPage} disabled={currentPage === totalPages}>
          Next
        </button>
      </div>
    </div>
  );
};

export default PokemonApp;
