using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using MyFirstApp.Models;
using Microsoft.Extensions.Logging;
using MyFirstApp.Core;

namespace MyFirstApp.Controllers
{
    public class MovieController : Controller
    {
        private readonly ILogger<MovieController> _logger;

        public MovieController(ILogger<MovieController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            _logger.LogInformation(LoggingEvents.GENERATE_ITEMS, " --- Generating Movie Items");
            var model = genericMovie();
            _logger.LogInformation(LoggingEvents.LIST_ITEMS, "  --- List All items");
            return View(model);
        }


        private List<Movie> genericMovie() {
            List<Movie> movieList = new List<Movie>();
            
            for (int i = 0; i < 3; i++) {
                Movie movie = new Movie();
                movie.ID = i;
                movie.Title = "Who am I?";
                movie.ReleaseDate = new DateTime(2016, 6, 1, 7, 47, 0);
                movie.Genre = "Action";
                movie.Price = 800;
                movieList.Add(movie);
            }
            
            return movieList;
        }

    }
}
