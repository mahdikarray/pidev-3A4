<?php

namespace App\Controller;

use App\Entity\Abonnement;
use App\Entity\Offre;
use App\Form\AbonnementType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/front')]
class FrontController extends AbstractController
{
    #[Route('/', name: 'app_abonnement_indexfront', methods: ['GET'])]
    public function index(EntityManagerInterface $entityManager): Response
    {
        $abonnements = $entityManager
            ->getRepository(Abonnement::class)
            ->findAll();

        $offres = $entityManager
            ->getRepository(Offre::class)
            ->findAll();

        return $this->render('abonnement/front.html.twig', [
            'abonnements' => $abonnements,
            'offres' => $offres,
        ]);
    }

    #[Route('/{idAb}', name: 'app_abonnement_frontshow', methods: ['GET'])]
    public function show(Abonnement $abonnement): Response
    {
        return $this->render('abonnement/frontshow.html.twig', [
            'abonnement' => $abonnement,
        ]);
    }


}