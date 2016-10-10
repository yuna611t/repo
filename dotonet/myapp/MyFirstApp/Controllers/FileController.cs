using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using MyFirstApp.Models;
using Microsoft.Extensions.FileProviders;


namespace MyFirstApp.Controllers
{
    public class FileController : Controller
    {
        private readonly IFileProvider _fileProvider;

        public FileController(IFileProvider fileProvider)
        {
            _fileProvider = fileProvider;
        }

        public IActionResult Index()
        {
           var contents = _fileProvider.GetDirectoryContents("");
           return View(contents);
        }


    }
}
